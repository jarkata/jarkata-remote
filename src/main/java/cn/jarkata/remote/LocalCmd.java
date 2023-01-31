package cn.jarkata.remote;

import java.util.Arrays;

public class LocalCmd {

    public static Result execLocalCmd(String command, int timeout) throws Exception {
        return CmdExecutor.exec(Arrays.asList("/bin/zsh", "-c", command),
                timeout);
    }
}