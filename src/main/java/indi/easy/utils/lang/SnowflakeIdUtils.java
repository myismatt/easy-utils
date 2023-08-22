package indi.easy.utils.lang;

/**
 * 雪花算法ID生成
 *
 * @author Matt
 */
public class SnowflakeIdUtils {

    private static final SnowflakeUtils ID_WORKER = new SnowflakeUtils();

    private SnowflakeIdUtils() {
    }

    public static SnowflakeIdUtils getInstance() {
        return InnerClass.INS;
    }

    public String getNextId() {
        return String.valueOf(ID_WORKER.nextId());
    }

    public Long getNextLongId() {
        return ID_WORKER.nextId();
    }

    private static class InnerClass {
        private static final SnowflakeIdUtils INS = new SnowflakeIdUtils();

    }
}