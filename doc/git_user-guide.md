# git user guide
## 1.6 시작하기 - Git 최초 설정
### 사용자 정보
Git을 설치하고 나서 가장 먼저 해야 하는 것은 사용자이름과 이메일 주소를 설정하는 것이다.

$ git config --global user.name "John Doe"

$ git config --global user.email johndoe@example.com

### 편집기

사용자 정보를 설정하고 나면 Git에서 사용할 텍스트 편집기를 고른다.

$ git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"

### 설정확인
git config --list 명령을 실행하면 설정한 모든 정보를 확인할 수 있다. 

$git config --list
diff.astextplain.textconv=astextplain                              
filter.lfs.clean=git-lfs clean -- %f                               
filter.lfs.smudge=git-lfs smudge -- %f                             
filter.lfs.process=git-lfs filter-process                          
filter.lfs.required=true                                           
.....

Git은 같은 키를 여러 파일(/etc/gitconfig 와 ~/.gitconfig 같은)에서 읽기 때문에 같은 키가 여러 개 있을 수도 있다. 그러면 Git은 나중 값을 사용한다.

$ git config user.name
kyoungiklee


Git이 설정된 값을 읽을 때 여러 파일에서 동일한 키에 대해 다른 값을 설정하고 있을 수 있다. 값이 기대한 값과 다를 수 있는데 값만 보고 쉽게 그 원인을 찾을 수 없다. 
이 때 키에 설정된 값이 어디에서 설정되었는지 확인할 수 있는데 다음과 같은 명령으로 어떤 파일로부터 설정된 값인지를 확인할 수 있다.

$ git config --show-origin user.name
file:C:/Users/User/.gitconfig   kyoungiklee

## 1.7 시작하기 - 도움말 보기


