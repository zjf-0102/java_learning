import com.nuist.dao.ActorDao;
import com.nuist.domain.Actor;
import org.junit.Test;

import java.util.List;

public class TestDao {
    //使用ActorDao对象对actor表进行操作
    @Test
    public void testActorDao(){
        ActorDao actorDao = new ActorDao();
        String sql = "select * from actor";
        List<Actor> actors = actorDao.queryMulti(sql, Actor.class);
        for (Actor actor:actors) {
            System.out.println(actor);
        }
    }
}
