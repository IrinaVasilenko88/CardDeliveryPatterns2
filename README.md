[![Build status](https://ci.appveyor.com/api/projects/status/14jpkmupjk4gtrxk?svg=true)](https://ci.appveyor.com/project/IrinaVasilenko88/carddeliverypatterns2)

# Обучение в Нетологии.

## Домашнее задание по курсу Автоматизированное тестирование

## Тема: Patterns
Тестирование функции входа через Web интерфейс(приложение ```app-ibank.jar```) с использованием Selenide

![](https://github.com/netology-code/aqa-homeworks/blob/aqa4/patterns/pic/order.png)

Написание тестов с условиями:

- наличие пользователя;
- статус пользователя;
- невалидный логин;
- невалидный пароль

**Для запуска проекта:**
1. Склонировать проект из репозитория командой 

```
git clone https://github.com/IrinaVasilenko88/CardDeliveryPatterns2.git
``` 
2. Открыть склонированный проект в Intellij IDEA
3. Открыть в терминале каталог ```artifacts```
4. Для запуска приложения в тестовом режиме ввести команду ```java -jar app-ibank.jar -P:profile=test```
5. Для запуска в браузере ввести ссылку  http://localhost:9999/
6. Запустить команду ```gradlew test```
