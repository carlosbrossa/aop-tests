package com.example;

import com.example.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class TestAOP {

    @Test
    public void test() throws Exception {

        ClientWatcher cLientWatcher = new ClientWatcher();

        Container container = new Container();
        container.register(Client.class, cLientWatcher);

        Client client = container.get(Client.class);
        client.getName();
        client.getProjects();
        client.getName();

        System.out.println(client.getClass().getName());
        Assert.assertEquals(3, cLientWatcher.getInvocation());



    }

}
