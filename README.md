# SUPER-PUPER-LOGIN-APP-BEST-EVER-LIKE-IT-FAST

### Test Data
Логин для входа без пароля: easy@sky.com
C паролем: hard@sky.com;1337hard
Код: 1337
Интернет соединение мокается по этому алгоритму: RandomUtils.getMockRandomUnavailable() % 3 != 0, где random(2-5)
### Траблы
Из-за даггера + джека может компилится только после чистки проекта. Рекомендую сделать кастомный конфиг на :clean каждый раз.
Также, на API < 14 констрейн лайаут ведет себя неадекватно и верстка рушится
### Version
1.0
### TODO
Реализовать приложение, единственной задачей которого является авторизация пользователя.
Критерии оценки:
Организация и качество программного кода
Подробности: 
API авторизации принимает на вход логин/пароль, возвращает токен jwt. В качестве API следует использовать заглушку.
В архитектуру приложения необходимо заложить возможность фоновой синхронизации данных с внешним веб-сервисом. Предполагается что при синхронизации будут использоваться данные, полученные при авторизации, синхронизация будет запускаться раз в сутки. Саму синхронизацию реализовывать не нужно.
После успешной авторизации пользователь попадает на экран с единственной кнопкой - logout (функционал logout должен быть реализован).
Приложение должно адекватно обрабатывать все возможные сценарии, UI должен максимально соответствовать предоставленным макетам.

### Architecture
 *  https://habrahabr.ru/company/rambler-co/blog/275943/
### Tech


* [Reactive Java] - java super reactive lib
* [Reactive Android] - android reactive lib
* [Dagger 2] - Awesome Hated dependecncy injection lib


### Todos

 - Write Tests
 - Add Code Comments

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Reactive Java]: <https://github.com/ReactiveX/RxJava>
   [Reactive Android]: <https://github.com/ReactiveX/RxAndroid>
   [Dagger 2]: <https://github.com/google/dagger>
   [Retrofit 2]: <http://square.github.io/retrofit/>
   [Picasso]: <https://ru.wikipedia.org/wiki/%D0%9F%D0%B8%D0%BA%D0%B0%D1%81%D1%81%D0%BE,_%D0%9F%D0%B0%D0%B1%D0%BB%D0%BE>

