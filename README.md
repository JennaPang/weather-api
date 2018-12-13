# Weather-api
## Synopsis
사용자가 직접 본인이 원하는 모양으로 편집할 수 있는 날씨 앱. 사용자가 회원가입을 할 때 1에서 4까지 가장 중요한 순서대로 드롭다운에서 날씨 정보를 선택하면 그에 맞춰 마지막 창인 날씨 정보 창을 만든다.
## Code Example
이 프로젝트는 총 6개의 .java 파일와 한개의 .txt 파일로 이루어져 있다. 각 파일의 기능은 아래와 같다.
+ account.txt
  + 모든 계정의 정보를 담고 있는 텍스트 파일로 모든 정보는 아래의 템플릿을 따른다.
  ```
  id:asdf
  password:asdf
  3 1 4 2           //사용자가 선택하는 정보의 순서
  id:1234
  password:1234
  4 3 2 1
  ```
+ MainClass.java
  + LogIn 클래스를 불러오는 용도로만 쓰이는 파일로, 사용자들이 execute해야하는 파일이 무엇인지 직관적으로 알 수 있도록 만든 파일이다.
+ LogIn.java
  + 사용자가 보는 첫 화면으로 로그인을 할지 회원가입을 할지 결정하도록 한다.
  + 로그인을 할 시, *account.txt* 파일에서 먼저 id를 찾고, 그 바로 다음줄에 있는 password가 JPasswordField에 있는 것과 동일한지 확인한다. 만약 일치할 시, Weather클래스를 열고 setVisible을 이용해 LogIn 창은 닫는다.
    ```c
    while ((line=reader.readLine()) != null) {
      if(line.equals("id:"+i)) {
        if(reader.readLine().equals("password:"+p)) {
          setVisible(false);
          new Weather(i,p);
        }
        else {
          JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요.");
        }
      }
    }
    ```
  + 회원가입을 할 시, *SignIn.java* 파일을 연다. 위와 동일하게 setVisible과 constructor을 사용하는 방식이다.
+ SignIn.java
  + asdf
                
