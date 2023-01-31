package cn.jarkata.remote;

import org.junit.Test;

import java.util.Arrays;

public class CmdExecutorTest {

    @Test
    public void exec() throws Exception {
        Result result = CmdExecutor.exec(Arrays.asList("/bin/zsh", "-c", "ps -ef| grep lira"), 10);
        System.out.println(result.getCode());
        System.out.println(result);
    }

    @Test
    public void execLocal() throws Exception {
        Result result = LocalCmd.execLocalCmd("ps -ef| grep lira", 10);
        System.out.println(result.getCode());
        System.out.println(result);
    }
}