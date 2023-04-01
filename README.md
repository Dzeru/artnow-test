Запуск тестов для Chrome:

```bash
mvn clean test -Dartnow-test.browser=CHROME
```

Запуск тестов для Firefox:

```bash
mvn clean test -Dartnow-test.browser=FIREFOX
```

Генерация отчета:

```bash
allure serve target/allure-results
```