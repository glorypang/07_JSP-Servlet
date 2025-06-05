package org.scoula.ex06;

import org.scoula.ex06.Controller.HomeController;
import org.scoula.ex06.Controller.TodoController;
import org.scoula.ex06.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// DispatcherServlet Servlet을 상속 받아createMap() 메서드 오버라이딩
// -> 기존 init() 메서드에 작성한 url, 커맨드 매핑 코드를 createMap()에 작성
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet  {

    /* 컨트롤러 객체 생성 */
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();

    /* DispatcherServlet 상속 */
    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

        // GET 매핑
        getMap.put("/", homeController::getIndex);
        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        // POST 매핑
        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }
}