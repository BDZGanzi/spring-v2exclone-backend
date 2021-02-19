package wallfacer5.exception;

public class BaseException extends Exception {

    public BaseException() {
        
    }

    public BaseException(String msg){
        super(msg);
    }

    public BaseException(String msg, Throwable cause){
        super(msg, cause);
    }

    public BaseException(Throwable cause){
        super(cause);
    }
}
