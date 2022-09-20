import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
//
    @Autowired
    private UserService userService;
//
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
/
    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDTO> saveUser(UserDTO user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
