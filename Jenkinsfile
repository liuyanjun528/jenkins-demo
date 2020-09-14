
def tag = "latest"
def harbor_url = "harbor.io.chenhujia.com:2001"
node {
    stage('git拉取代码'){
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git', url: 'git@github.com:liuyanjun528/jenkins-demo.git']]])
    }

     stage('maven 打包jenkins-demo'){
            sh "mvn -f jenkins-demo clean install -Dmaven.test.skip=true"
        }

      stage('harbor拉取镜像，启动容器'){
             //jenkins连接harbor凭证
             withCredentials([usernamePassword(credentialsId: 'dd9b9226-492e-4aa5-bded-cd53311883bd', passwordVariable: 'password', usernameVariable: 'username')]) {

             //ssh  连接
             sshPublisher(publishers: [sshPublisherDesc(configName: 'service', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "/root/jenkins-shell/jenkins-demo.sh $harbor_url $tag", execTimeout: 12000000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

            }
      }
}
