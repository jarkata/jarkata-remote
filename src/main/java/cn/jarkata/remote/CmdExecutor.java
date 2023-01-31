package cn.jarkata.remote;

import cn.jarkata.commons.utils.FileUtils;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CmdExecutor {

    public static Result exec(List<String> commands, int timeout) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        return processResult(process, timeout, commands);
    }


    protected static Result processResult(Process process, int timeout, List<String> commands) throws Exception {
        InputStream inputStream = process.getInputStream();
        List<String> result = FileUtils.readLines(inputStream);
        if (process.isAlive()) {
            process.waitFor(timeout, TimeUnit.SECONDS);
        }
        int exitValue = process.exitValue();
        return new Result(exitValue, result, commands);
    }
}