package reflection;

import bean.SuperStar;
import org.apache.ibatis.reflection.ArrayUtil;
import org.apache.ibatis.reflection.ParamNameUtil;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @Title：
 * @Author：wangchenggong
 * @Date 2020/10/4 22:59
 * @Description
 * @Version
 */
public class TestParamNameUtil {

    public static void main(String[] args) throws Exception {

        /**
         * maven中增加配置，并对rebuild project：
         *             <plugin>
         *                 <groupId>org.apache.maven.plugins</groupId>
         *                 <artifactId>maven-compiler-plugin</artifactId>
         *                 <configuration>
         *                     <source>8</source>
         *                     <target>8</target>
         *
         *                     <compilerArgs>
         *                         <arg>-parameters</arg>
         *                     </compilerArgs>
         *                 </configuration>
         *             </plugin>
         */
        Class<SuperStar> superStarClazz = SuperStar.class;
        Method joinPartyMethod = superStarClazz.getDeclaredMethod("joinParty", String.class, Date.class);
        List<String> paramNames = ParamNameUtil.getParamNames(joinPartyMethod);
        System.out.println(ArrayUtil.toString(paramNames));
    }

}
