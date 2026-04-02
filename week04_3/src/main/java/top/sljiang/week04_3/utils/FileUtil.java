package top.sljiang.week04_3.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import top.sljiang.week04_3.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class FileUtil {

    private static String UPLOAD_DIR;
    private static boolean dirInited = false;

    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            ".txt", ".md", ".csv",
            ".zip", ".rar", ".7z",
            ".json", ".xml"
    );

    // 核心修复：Windows 路径兼容
    private static void initUploadDir() {
        if (dirInited)
        {
            return;
        }

        try {
            // 获取项目编译后的 classes 目录（修复 Windows 路径开头多余 /）
            File classesDir = new File(FileUtil.class.getResource("/").getPath());
            String baseDir = classesDir.getAbsolutePath();

            // 拼接路径：classes/static/upload/
            Path uploadPath = Paths.get(baseDir, "static", "upload");
            Files.createDirectories(uploadPath);

            UPLOAD_DIR = uploadPath.toString() + File.separator;
            log.info("上传目录初始化成功: {}", UPLOAD_DIR);
            dirInited = true;
        } catch (Exception e) {
            log.error("上传目录初始化失败", e);
            throw new RuntimeException("创建上传目录失败", e);
        }
    }

    public static String upload(MultipartFile file) throws IOException {
        initUploadDir();

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException("文件名不能为空", 400);
        }

        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException("不支持的文件类型: " + suffix, 400);
        }

        String fileName = UUID.randomUUID() + suffix;
        File dest = new File(UPLOAD_DIR + fileName);
        file.transferTo(dest);
        return fileName;
    }
}