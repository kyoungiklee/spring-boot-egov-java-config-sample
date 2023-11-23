# spring-boot-egov-java-config-sample

## git push (기존사용자 repository에서 신규사용자 repository로 remote 변경 시)
$ git config --global user.name kyoungiklee
$ git config --global user.email kyoungik.lee+1@gmail.com
$ git remote add origin https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git

$ git push -u origin main

#### 오류 발생
remote: Permission to kyoungiklee/spring-boot-egov-java-config-sample.git denied to roadseeker.
fatal: unable to access 'https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git/': The requested URL returned error: 403

#### 처리 내용
$ git branch -M main

$ git branch
```
* main
```


$ git push -u origin main:ㅂ!

  remote: Permission to kyoungiklee/spring-boot-egov-java-config-sample.git denied to roadseeker.
  fatal: unable to access 'https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git/': The requested URL returned error: 403


$ git pull origin main
```
From https://github.com/kyoungiklee/spring-boot-egov-java-config-sample
* branch            main       -> FETCH_HEAD
  fatal: refusing to merge unrelated histories
```

#### 윈도우 제어판 > 사용자계정 > 자격 증명 관리자 > Windows 자격 증명 > 일반자격증명 > git:https://github 
사용자 이름 / 암호 변경

$ git push origin main
```
remote: Support for password authentication was removed on August 13, 2021.
remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
fatal: Authentication failed for 'https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git/'
```

#### github > Settins > Developer settings > Personal access tokens > Tokens(classic) 토큰생성
$ git config --global user.password ghp_7************************************

$ git push -u origin main
```
info: please complete authentication in your browser...
remote: Permission to kyoungiklee/spring-boot-egov-java-config-sample.git denied to roadseeker.
fatal: unable to access 'https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git/': The requested URL returned error: 403
```

$ git config --global user.name kyoungiklee

$ git push -u origin main
```
To https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git
! [rejected]        main -> main (non-fast-forward)
error: failed to push some refs to 'https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```


$ git pull origin main
```
From https://github.com/kyoungiklee/spring-boot-egov-java-config-sample
* branch            main       -> FETCH_HEAD
  fatal: refusing to merge unrelated histories
```

$ git pull origin main --allow-unrelated-histories
```
From https://github.com/kyoungiklee/spring-boot-egov-java-config-sample
* branch            main       -> FETCH_HEAD
  Merge made by the 'ort' strategy.
  README.md | 1 +
  1 file changed, 1 insertion(+)
  create mode 100644 README.md
```

$ git push -u origin main
```
Enumerating objects: 155, done.
Counting objects: 100% (155/155), done.
Delta compression using up to 8 threads
Compressing objects: 100% (121/121), done.
Writing objects: 100% (154/154), 95.96 KiB | 1.45 MiB/s, done.
Total 154 (delta 25), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (25/25), done.
To https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git
d19022d..9897b6b  main -> main
branch 'main' set up to track 'origin/main'.
```

### .git > config 정보 변경 (github push 시 인증 실패시 처리)
```
remote "origin"]
url = https://github.com/kyoungiklee/spring-boot-egov-java-config-sample.git
fetch = +refs/heads/*:refs/remotes/origin/*
-->
remote "origin"]
url = https://kyoungiklee:ghp_7f0ybqBY7G5o***************@github.com/kyoungiklee/spring-boot-egov-java-config-sample.git
fetch = +refs/heads/*:refs/remotes/origin/*
```

