package shop.mtcoding.blog.board;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("boardId", id + "");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        request.setAttribute("boardId", id);
        return "board/updateForm";
    }
}
