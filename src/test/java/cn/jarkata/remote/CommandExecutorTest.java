package cn.jarkata.remote;

import org.junit.Test;

import java.util.Arrays;

public class CommandExecutorTest {

    @Test
    public void exec() throws Exception {
        Result result = CommandExecutor.exec(Arrays.asList("/bin/sh", "-c", "ps -ef| grep java"), 10);
        System.out.println(result.getCode());
    }
}