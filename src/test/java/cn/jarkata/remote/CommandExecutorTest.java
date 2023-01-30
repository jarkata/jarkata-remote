package cn.jarkata.remote;

import org.junit.Test;

import java.util.Arrays;

public class CommandExecutorTest {

    @Test
    public void exec() throws Exception {
        Result result = CommandExecutor.exec(Arrays.asList("/bin/zsh", "-c", "ps -ef| grep lira"), 10);
        System.out.println(result.getCode());
        System.out.println(result);
    }
}