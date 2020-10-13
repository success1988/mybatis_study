package logging;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/9 22:50
 * @Description
 * @Version
 */
public class TestLog {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(TestLog.class);
        log.error("发生异常了");

    }
}
