package com.testswithpom.projectpom.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SignInWithExistingUser.class, AddToCard.class})
public class TestSuit {
    /**
     * 1. Открываем сайт http://automationpractice.com 2. Логинимся 3. Используя метод moveToElement
     * из класса Actions наводим на категорию Women 4. Ждем когда появятся подкатегории и открываем
     * EVENING DRESSES 5. Открываем в новой вкладке единственный товар 6. Переходим на новую вкладку
     * 7. Выбираем розовый цвет и размер L 8. В диалоге выбираем Continue Shopping 9. Используя
     * метод moveToElement наводим на Cart в верхем правом углу 10. Проверяем что там отображается
     * верный цвет и размер 11. Кликаем на "х" чтобы удалить товар 12. Проверяем что теперь в Cart
     * висит слово (empty) 13. Закрываем вкладку 14. Возвращаемся на первую вкладку 15. Вытягиваем
     * все куки и выводим их имена в консоль*
     */
}
