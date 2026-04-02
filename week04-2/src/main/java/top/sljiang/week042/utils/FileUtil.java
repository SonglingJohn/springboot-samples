package top.sljiang.week042.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.ResourceUtils;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

/**
 * @author mqxu
 * @date 2026/3/26
 * @description 文件上传工具类
 **/
@Slf4j
public class FileUtil {
    private static final String UPLOAD_DIR = getUploadDir();

    static {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException("创建上传目录失败: " + UPLOAD_DIR);
            }
        }
    }

    /**
     * 允许上传的文件类型白名单
     */
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            // 图片
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            // 文档
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            // 文本
            ".txt", ".md", ".csv",
            // 压缩包
            ".zip", ".rar", ".7z",
            // 其他
            ".json", ".xml"
    );

    /**
     * 获取上传目录
     * @return 上传目录
     */
    private static String getUploadDir() {
        try {
            // 获取项目根目录
            String baseDir = ResourceUtils.getURL("classpath:").getPath();
            // 创建上传目录
            Path uploadPath = Paths.get(baseDir, "static/upload/");
            Files.createDirectories(uploadPath);
            String uploadDir = uploadPath.toAbsolutePath() + "/";
            log.info("上传目录: {}", uploadDir);
            return uploadDir;
        } catch (IOException e) {
            throw new RuntimeException("创建上传目录失败", e);
        }
    }

    /**
     * 文件上传
     *
     * @param file 上传文件
     * @return 文件名
     */
    public static String upload(MultipartFile file) throws IOException {
        // 文件名校验
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException( "文件名不能为空",400);
        }
        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        // 文件类型校验
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException("不支持的文件类型: " + suffix,400);
        }
        // 拼接新文件名，并创建新文件
        String fileName = UUID.randomUUID() + suffix;
        File dest = new File(UPLOAD_DIR + fileName);
        // 保存新文件到上传目录（上传）
        file.transferTo(dest);
        return fileName;
    }
}