package com.example.springboot_web_admin;

import com.example.springboot_web_admin.bean.user;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@DisplayName("Redis")
class SpringbootWebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    StringRedisTemplate redisTemplate;
//    @Autowired
//    Jedis jedis;
//    @Autowired
//    JedisConnectionFactory jedisConnectionFactory;
//    @Test
//    void contextLoads() throws SQLException {
//        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user ", Integer.class);
//        System.out.println(integer);
//        List<user> maps = jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(user.class));
//        for (user map : maps) {
//           log.info("{}",map);
//        }
//        log.info("数据源类型:{}",dataSource.getConnection());
//    }
    @Test
    public void  testTemplate(){
//        stringRedisTemplate.opsForValue().set("hello","java");
//        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
//        stringRedisTemplate.opsForValue();
//        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
//        Boolean hello = valueOperations.setIfAbsent("hello", "c++");
//        System.out.println(hello);
    }
    @Test
    @DisplayName("RedisDisplayName")
    @Timeout(value = 200,unit = TimeUnit.MICROSECONDS)
    public void  testTJedis() throws InterruptedException {
//        System.out.println(jedisConnectionFactory.getClass());
//        System.out.println(jedis.keys("*"));
        Jedis jedis = new Jedis("192.168.200.128", 6379);
        System.out.println(jedis.keys("*"));
        Thread.sleep(500);
    }
    @Test
//    @Disabled
    @RepeatedTest(5)
    void test2(){
        System.out.println(2);
    }
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始了");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("all测试开始了");
    }
    @AfterAll
    static void testBl(){
        System.out.println("all测试结束了");
    }
    @Test
    @DisplayName("测试断言")
    public void testCal(){
        int cal = cal(1, 1);
       Assertions.assertEquals(2 ,cal,"业务逻辑计算失败");
       Object object1=new Object();
       Object object2=new Object();
       Assertions.assertSame(object1,object2,"不是同一个对象");
    }
    int cal(int i,int j){
        return i+j;
    }
    @Test
    void all(){
        assertAll(()->{
           assertTrue(1==1);
        },()->{
            assertEquals(1,1);
        });
        assertThrows(ArithmeticException.class,()->{
            System.out.println(1/0);
        },"为什么没有出异常!");
        if(1<2){
            fail("干甚!");
        }
    }
    @Test
    void testAssumptions(){
//        Assumptions.assumeTrue(1==2,"为啥啊");
//        assertEquals(1,1,"sha");
fail("有人吗");
    }
    @Test
    @ParameterizedTest
    @ValueSource(strings ={"1","2","3"})
    public void testResource(String string){
        System.out.println(string);
        Assertions.assertTrue(string!=null);
    }
}
