package mydomain.model;

import java.util.*;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class A
{
    @PrimaryKey
    Long id;

    String name;

    @Persistent(defaultFetchGroup="true")
    @Join
    List<B> bs = new ArrayList<>();

    public A(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Collection<B> getBs()
    {
        return bs;
    }
}
