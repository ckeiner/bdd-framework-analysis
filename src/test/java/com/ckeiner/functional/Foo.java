package com.ckeiner.functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Foo
{
    public Bar bar;

    public void executeMethod(Runnable runner)
    {
        runner.run();
    }

    public void consumeObject(Consumer<Bar> consumer)
    {
        consumer.accept(this.bar);
    }

    public void setBarWith(Supplier<Bar> barSupplier)
    {
        this.bar = barSupplier.get();
    }

    public static void main(String[] args)
    {
        Foo foo = new Foo();
        foo.setBarWith(() -> new Bar("qed"));
        foo.executeMethod(() ->
            {
                System.out.println("This is a runnable.");
            });
        foo.consumeObject(parameterOfTypeBar ->
            {
                System.out.println("With a consumer, you can use the parameter however you like "
                        + parameterOfTypeBar.getPhrase());
            });
    }
}
