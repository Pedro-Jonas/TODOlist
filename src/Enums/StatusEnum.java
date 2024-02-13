package Enums;

public enum StatusEnum {
    TODO("todo"), DOING("doing"), DONE("done");

    private final String status;
    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

