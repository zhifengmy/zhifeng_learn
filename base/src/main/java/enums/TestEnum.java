package enums;

public enum TestEnum {

    MALE(1, "男性"),
    FMALE(2, "女性");

    Integer code;
    String desc;

    TestEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
