package wallfacer5.enums;

public enum StatusCode {
    OK(200, "msg:OK"),
    MULTIPLE_CHOICE(300, "msg:Multiple choice");

    private final int code;
    private final String msg;

    StatusCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
