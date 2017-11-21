1.Servlet没有main方法，
他们受控于另一个Java应用，这个Java应用称为容器
Tomcat-容器
客户请求-》Web服务器应用(Apache)-》Tomcat-》【调用doPost()和doGet()，向servlet提供Http请求和响应】

如果没有servlet，我们只是能用核心的J2SE库而已
所以servlet提供了对web服务器应用的支持

2.容器能提供什么
    a.通讯支持
    轻松的让servlet和Web服务器之间对话
    b.生命周期管理
    控制servlet的生与死，负责加载类.实例化和初始化servlet，调用servlet方法，并使servlet实力能够被垃圾回收
    c.多线程支持
    自动地为它接收的每个servlet请求创建一个新的Java线程
    d.声明方式实现安全
    可以使用XML部署描述文件配置安全性，而不用硬编码到servlet类代码中
    e.JSP支持

3.容器如何处理请求
    容器根据请求中的URL找到正确的servlet，为这个请求创建或分配一个线程，并把请求和响应对象传递给这个servlet线程容器调用servlet的
    service()方法，根据请求类型的不同，service()方法会调用doGet或doPost方法，例如:GET请求，doGet方法生成动态页面，并把这个页面"填
    入"响应对象。线程结束，容器把响应对象转换为一个HTTP响应，把它发回给客户，然后删除请求和响应对象

4.J2EE应用服务器包括一个Web容器和一个EJB容器
独立的Web容器通常配置为与一个HTTPWeb服务器(Apache)协作，不过Tomcat容器本身就能作为一个基本的Http服务器，但是在HTTP服务器功能方面，
Tomcat没有Apache那么健壮，所以最常见的非EJBWeb应用通常会结合使用Apache和Tomcat，Apache作为HTTPWeb服务器，Tomcat作为Web容器
