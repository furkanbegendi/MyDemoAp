package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    App obj;

    public void initialize()
    {
        obj=new App();
    }


    public void test1()
    {
        initialize();
        int[] a={1,2,3};
        assertEquals("Furkan:1-2-3\nSelin:1-2-3",obj.method(a,a,"Furkan","Selin"));
    }

    public void test2()
    {
        initialize();
        int[] a={5,9,10};
        int[] b={2,7,67};
        assertEquals("Oğuzhan:5-9-10\nSafa:2-7-67",obj.method(a,b,"Oğuzhan","Safa"));
    }

    public void test3()
    {
        initialize();
        int[] a={1,2,3};
        int[] b={2,3,4};
        assertEquals("Berkehan:1-2-3\nIrmak:2-3-4",obj.method(a,b,"Berkehan","Irmak"));
    }

    public void test4()
    {
        initialize();
        int[] a={9,7,5};
        int[] b={10000,20000,30000};

        assertEquals("Konur:9-7-5\nAylin:10000-20000-30000",obj.method(a,b,"Konur","Aylin"));

    }

    public void test5()
    {
        initialize();
        int[] a={4,5,6};
        int[] b={32,25,36};

        assertEquals("Hakkı:4-5-6\nDoğaner:32-25-36",obj.method(a,b,"Hakkı","Doğaner"));
    }

}
