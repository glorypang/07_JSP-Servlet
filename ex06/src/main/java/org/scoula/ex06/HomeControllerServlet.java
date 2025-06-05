package org.scoula.ex06;

import org.scoula.ex06.Controller.HomeController;
import org.scoula.ex06.Controller.TodoController;
import org.scoula.ex06.command.Command;

import javax.servlet.annotation.WebServlet;
import java.util.Map;


// DispatcherServlet Servlet을 상속 받아createMap() 메서드 오버라이딩
// -> 기존 init() 메서드에 작성한 url, 커맨드 매핑 코드를 createMap()에 작성
@WebServlet(name = "frontControllerServlet", value = "/")
public class HomeControllerServlet extends DispatcherServlet  {

    /* 컨트롤러 객체 생성 */
    HomeController homeController = new HomeController();

    /* DispatcherServlet 상속 */
    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

        // GET 매핑
        getMap.put("/", homeController::getIndex);
    }
}