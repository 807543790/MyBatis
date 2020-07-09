# MyBatis

<?xml version="1.0" encoding="UTF-8" ?>
         <!DOCTYPE configuration
                 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
                 "http://mybatis.org/dtd/mybatis-3-config.dtd">
         <!--以下标签严格按照顺序放置，否则会报错-->
         <configuration>
             <!-- 一：使用properties标签调用db.properties动态传入数据库连接的数据 这样就不用单独配置多个环境了-->
             <properties resource="db.properties"></properties>
         
         
             <!--二：配置设置-->
             <!--<settings>-->
                 <!--&lt;!&ndash;使用默认日志&ndash;&gt;-->
                 <!--<setting name="logImpl" value="STDOUT_LOGGING"/>-->
             <!--</settings>-->
         
         
             <!--三：类型别名 定义好别名后直接在文件中使用别名即可 注意不区分大小写-->
             <!--<typeAliases>-->
                 <!--&lt;!&ndash;1.定义一个实体类别名&ndash;&gt;-->
                 <!--&lt;!&ndash;<typeAlias type="com.com.monkey.pojo.user" alias="User"/>&ndash;&gt;-->
         
                 <!--&lt;!&ndash;2.扫描包下所有的实体类名称，用默认实体类名称即可&ndash;&gt;-->
                 <!--&lt;!&ndash;<package name="com.zhangbin.pojo"/>&ndash;&gt;-->
         
                 <!--&lt;!&ndash;3.使用注解@Alias直接定义别名使用&ndash;&gt;-->
             <!--</typeAliases>-->
         
         
             <!--四：default指定那个环境就是那个环境-->
             <environments default="development">
         
                 <!--本地环境-->
                 <environment id="development">
                     <transactionManager type="JDBC"/>
                     <dataSource type="POOLED">
                         <property name="driver" value="${driver}"/>
                         <property name="url" value="${url}"/>
                         <property name="username" value="${username}"/>
                         <property name="password" value="${password}"/>
                     </dataSource>
                 </environment>
         
                 <!--测试环境-->
                 <environment id="test">
                     <transactionManager type="JDBC"/>
                     <dataSource type="POOLED">
                         <property name="driver" value="${driver}"/>
                         <property name="url" value="${url}"/>
                         <property name="username" value="${username}"/>
                         <property name="password" value="${password}"/>
                     </dataSource>
                 </environment>
             </environments>
         
             <!--五：绑定接口-->
             <!--每一个mapper.xml都需要在mybatis核心配置文件中注册-->
             <mappers>
                 <!--1.resource绑定的是XML文件    【建议使用，有一个写一个mapper】-->
                 <mapper resource="com/zhangbin/dao/UserMapper.xml"></mapper>
                 <!--2.class绑定的是接口-->
                 <!--使用说明：接口和他的mapper配置文件必须同名-->
                 <!--接口和他的mapper配置文件必须在同一个包下-->
                 <!--使用注解需要配置接口，注意XML和接口不能配在一个mapper里，否则会报错-->
                 <mapper class="com.zhangbin.dao.UserMapperInteFace"></mapper>
         
                 <!--3.使用扫描包-->
                 <!--使用说明：接口和他的mapper配置文件必须同名-->
                 <!--接口和他的mapper配置文件必须在同一个包下-->
                 <!--<package name="com.com.monkey.com.com.monkey.dao"/>-->
             </mappers>
         </configuration>