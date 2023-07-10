pipeline {
    agent any
    triggers { cron('H */4 * * 1-5') }
    stages {
        stage('build') {
            steps {
                bat 'gradlew.bat clean build -x test'
            }
        }
        stage('test-firefox') {
            steps {
                withCredentials([string(credentialsId: 'password-github', variable: 'password')]) {
                    bat "gradlew.bat test -Dcontext=firefox -Dwebdriver.driver=firefox"
                }
            }
        }
        stage('aggregate') {
            steps {
                bat 'gradlew.bat aggregate'
            }
        }
        stage('publish report'){
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity-BDD',
                    reportTitles: ''
                ])
            }
        }
    }
}