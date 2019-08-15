/**!
 * @className prjpatterns.Singleton.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */

package prjpatterns;

public class Singleton {

    private static Menu myMenu;

    public static Menu getMyMenu()
    {
        return myMenu = new Menu();
    }
}
