import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Mock
    private Cat cat;
    private Dog dog  = new Dog(); // без Мока

    @Test
    public void test() {
        Mockito.when(cat.createHalfCat()).thenReturn(new Cat(2, "Я самый умный"));  // стаб, возвращающий половину кота с параметрами - 2 лапы, говорит "Я самый умный"
        Cat halfCat = cat.createHalfCat();
        CatDog catDog = new CatDog(halfCat, dog.createHalfDog());
        Assert.assertEquals(4, catDog.getLegsCount());// проверка, что у Котопса 4 лапы
        Assert.assertEquals("Единственный в мире малыш Котопёс", catDog.getSound());// проверка, что Котопёс говорит "Единственный в мире малыш Котопёс"
    }
}