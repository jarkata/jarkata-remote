package cn.jarkata.remote;

import java.util.List;

public class Result {
    private int code;
    private List<String> desc;
    private List<String> command;

    public Result(int code, List<String> desc, List<String> command) {
        this.code = code;
        this.desc = desc;
        this.command = command;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public List<String> getCommand() {
        return command;
    }

    public void setCommand(List<String> command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "Result{" + "code=" + code +
                ", desc=" + desc +
                ", command=" + command +
                '}';
    }
}