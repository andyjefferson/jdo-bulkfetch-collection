package org.datanucleus.test;

import java.util.*;
import org.junit.*;
import javax.jdo.*;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("MyTest");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();

            A p1 = new A(1, "First");
            B u1 = new B(1, "u1");
            p1.getBs().add(u1);
            pm.makePersistent(p1);

            A p2 = new A(2, "Second");
            B u2 = new B(2, "p2");
            p2.getBs().add(u2);
            B u3 = new B(3, "p3");
            p2.getBs().add(u3);
            pm.makePersistent(p2);

            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        pmf.getDataStoreCache().evictAll();

        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();

            NucleusLogger.GENERAL.info(">> newQuery");
            Query q = pm.newQuery("SELECT FROM mydomain.model.A");
            NucleusLogger.GENERAL.info(">> q.executeList");
            List<A> results = q.executeList();
            for (A a : results)
            {
                NucleusLogger.GENERAL.info(">> a=" + a);
                NucleusLogger.GENERAL.info(">>     a.bs = " + a.getBs());
            }

            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        pmf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}
