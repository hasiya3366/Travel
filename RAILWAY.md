Railway build notes

This project is configured to build with the Maven wrapper and use the `production` profile.

# Build command

Use the following build command in Railway:

```bash
bash railway-build.sh
```

# Start command

Use this start command in Railway:

```bash
java -jar target/TravelApp-0.0.1-SNAPSHOT.jar
```

# Environment variables

Set these Railway variables exactly as shown. Do not include `jdbc:` in `SPRING_DATASOURCE_URL`.

- `SPRING_DATASOURCE_URL` = `mysql://mysql.railway.internal:3306/railway`
- `SPRING_DATASOURCE_USERNAME` = `root`
- `SPRING_DATASOURCE_PASSWORD` = `zTFdGbyzAcTGnNaFJqoectelDmYxvSyG`

Railway provides `PORT` automatically, and the application already reads it from `application.properties`.

# Repository details

- Branch: `main`
- Project root: repository root containing `pom.xml`

# Notes

- `railway-build.sh` runs:

```bash
./mvnw -Pproduction -DskipTests clean package
```

- If Railway rejects the script execution, use `bash railway-build.sh` as the build command instead.
- Do not add database credentials into source files; keep them in Railway variables only.
