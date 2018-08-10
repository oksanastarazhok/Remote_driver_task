# Remote_driver_task (Healper from Pavel)

1. Добавить в тест получение пропертей из pom

String testString = System.getProperty("testString");

2. Добавить в pom файл определение пропертей

<properties>
       <testString>${testString}</testString>
   </properties>
   
 3. Добавить настройку получение проперти из командной строки мавена
<plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-surefire-plugin</artifactId>
               <configuration>
                
                <!-- since 2.5 -->

                   <systemPropertyVariables>
                       <testString>${testString}</testString>
                   </systemPropertyVariables>
                   <!-- deprecated -->
                   <!--<systemProperties>-->
                       <!--<property>-->
                           <!--<name>testString</name>-->
                           <!--<value>${testString}</value>-->
                       <!--</property>-->
                   <!--</systemProperties>-->
               </configuration>
           </plugin>
       </plugins>
       
  4. Протестировать работу mvn консоли

-Dtest=RemoteDriverExample test -DtestString=1005. Пушнуть апдейты в Дженкинс6. Добавить -Dtest=RemoteDriverExample test -DtestString=100 в Jenkins
