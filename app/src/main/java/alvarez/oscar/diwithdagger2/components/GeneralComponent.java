package alvarez.oscar.diwithdagger2.components;

import alvarez.oscar.diwithdagger2.MainActivity;
import alvarez.oscar.diwithdagger2.modules.MathGroupModule;
import dagger.Component;

/**
 * Created by Oscar Álvarez on 05/11/17.
 */

@Component(modules = {MathGroupModule.class})
public interface GeneralComponent {
    void inject(MainActivity mainActivity);
}
