package exceptions;

import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;

/**
 * @Title：myBatis异常包测试类
 * @Author：wangchenggong
 * @Date 2020/10/1 11:04
 * @Description 参考文章：https://blog.csdn.net/lqzkcx3/article/details/84944285
 * @Version
 */
public class TestException {


    /**
     * ErrorContext因为使用了ThreadLocal<T>, 我们就能直接取到之前执行本SQL的线程上的信息, 也就很方便的构建出异常发生时的上下文，快速排错
     * 执行效果：
     * Exception in thread "main" org.apache.ibatis.exceptions.PersistenceException:
     * ### Error invoke main method.  Cause: java.lang.ArithmeticException: / by zero
     * ### The error may involve TestException.doCompute
     * ### The error occurred while invoke my main method
     * ### Cause: java.lang.ArithmeticException: / by zero
     * 	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:41)
     * 	at exceptions.TestException.main(TestException.java:26)
     * Caused by: java.lang.ArithmeticException: / by zero
     * 	at exceptions.TestException.doCompute(TestException.java:34)
     * 	at exceptions.TestException.main(TestException.java:24)
     * @param args
     */
    public static void main(String[] args) {
        try {
            ErrorContext.instance().activity("invoke my main method");
            doCompute(5, 0);
        } catch (Exception e) {
            //若发生异常，则抛出包装后的异常，它包含了上下文信息，会调用到ErrorContext的toString方法输出上下文信息
            throw ExceptionFactory.wrapException("Error invoke main method.  Cause: " + e, e);
        } finally {
            //若未发生异常，则清空上下文信息，避免污染后续的上下文信息增加排错的难度
            ErrorContext.instance().reset();
        }
        //do other things
    }

    private static void doCompute(int a, int b) {
        ErrorContext.instance().object("TestException.doCompute");
        int result = a/b;
    }


}
