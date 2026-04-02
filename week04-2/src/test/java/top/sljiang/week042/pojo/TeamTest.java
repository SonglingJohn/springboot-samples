package top.sljiang.week042.pojo;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TeamTest {

    @Resource
    private Team team;

    @Test
    void testTeamConfigInjection() {
        // 1. 断言对象不为null
        assertNotNull(team, "Team Bean 注入失败");

        // 2. 打印
        log.info("team 信息：{}", team);

        // 3. 字段非空断言
        assertNotNull(team.getLeader());
        assertNotNull(team.getAge());
        assertNotNull(team.getEmail());
        assertNotNull(team.getPhone());
        assertNotNull(team.getCreateTime());

        // 4. 规则断言
        assertTrue(team.getLeader().length() >= 2);
        assertTrue(team.getAge() >= 30 && team.getAge() <= 60);
        assertTrue(team.getEmail().contains("@"));
        assertEquals(11, team.getPhone().length());
        assertTrue(team.getCreateTime().isBefore(LocalDate.now()));

        log.info("✅ 所有断言通过！");
    }
}