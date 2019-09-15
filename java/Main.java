import ru.models.User;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("hello","123");
        User user1 = new User("hello1","");
        User user2 = new User("hello2","");
        User user3 = new User("hello","");
        Set<User> set = new HashSet<>();
            set.add(user);
            set.add(user1);
            set.add(user2);
        System.out.println(set.add(user3));

        System.out.println();

            }

}
