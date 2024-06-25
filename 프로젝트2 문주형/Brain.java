package p1;

import java.util.*;

public class Brain implements Interface {
    static HashMap<String, String> Word = new HashMap<>();

    public Brain(){
        Word.put("Peach", "복숭아");
        Word.put("Plum", "자두");
        Word.put("Pomegranate", "석류");
        Word.put("Persimmon", "감");
    }


    // 메뉴
    @Override
    public void Menu(){
        System.out.println("등록된 단어 수 : \n" + Word.size());
        System.out.println("---- 선택 해주세요. ----");
        System.out.println(" 1. 단어 등록 ");
        System.out.println(" 2. 단어 조회 ");
        System.out.println(" 3. 단어 삭제 ");
        System.out.println(" 4. 테스트 ");
        System.out.println(" 5. 단어 목록보기");
        System.out.println(" 6. 종료 ");
        System.out.println("-----------------------");
    }

    // 1. 단어 등록
    @Override
    public void AddWord(){
        String Eng = null;
        String Kor = null;


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(" 등록할 영단어를 입력하세요.(목록으로 돌아가려면 Menu입력):");
            
            Eng = sc.nextLine();
            if (Eng.equals("Menu") || Eng.equals("Menu") ) {
                break;
            }else{
                if (Word.containsKey(Eng) == true) {
                    System.out.println(" 이미 입력된 단어입니다. 수정을 원하시면 삭제 후 다시 입력해주세요.");
                }else{
                    System.out.print(" 뜻을 입력하세요. : ");
                    Kor = sc.nextLine();
                    
                    try{
                        Word.put(Eng, Kor);
                    }catch(Exception e){
                        System.out.println(" 다시 입력해주세요. ");
                        e.printStackTrace();
                    }finally{
                        System.out.println(" 입력되었습니다. ");
                    }
                }
            }
        }
    }

    // 2. 단어 조회
    @Override
    public void WordSearch(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" 조회하고 싶은 영단어를 입력하세요.(목록으로 돌아가려면 Menu입력):");
            String Eng = sc.nextLine();
            if (Eng.equals("menu") || Eng.equals("Menu")) {
                break;
            }else{
                if (Word.containsKey(Eng) == true) {
                    System.out.println(Word.get(Eng));
                }else{
                    System.out.println("등록되지 않은 단어입니다.");
                }
            }
        }
    }

    // 3. 단어 삭제
    @Override
    public void DeleteWord(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ==== 단어 목록 ==== ");
            Set Key = Word.keySet();
            Iterator iterator;

            for(iterator = Key.iterator(); iterator.hasNext();){
                String KeyValue = (String) iterator.next();
                String ValueVar = (String) Word.get(KeyValue);

                System.out.println("※  " + KeyValue + " : " + ValueVar);
            }
            System.out.println(" ============== ");
            
            System.out.println(" 삭제하고 싶은 단어를 입력하세요.(목록으로 돌아가려면 Menu입력):");
            String Del = sc.nextLine();
            if (Del.equals("menu") || Del.equals("Menu")) {
                break;
            }else{
                if (Word.containsKey(Del) == true) {
                    System.out.println(" 입력한 단어 ( " + Del + " : " + Word.remove(Del) + ") 가 삭제되었습니다.");
                }else{
                    System.out.println("존재하지 않는 단어입니다.");
                }
            }
        }
    }

    // 4. 테스트
    @Override
    public void Test(){
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println(" 1. 시작하기 ");
            System.out.println(" 2. 종료하기 ");

            int a = sc.nextInt();
            if (a == 1) {
                Set Key = Word.keySet();
                int count = 0;
                int totalCount = 0;
                Iterator iterator;
                System.out.println(" ==== 뜻에 맞는 영단어를 입려하세요. ====");
                for (iterator = Key.iterator(); iterator.hasNext();){
                    String KeyValue = (String) iterator.next();
                    String ValueVar = (String) Word.get(KeyValue);
                    Scanner scan = new Scanner(System.in);
                    System.out.println(ValueVar);
                    String Answer = scan.nextLine();

                    if (Answer.equals(KeyValue)) {
                        System.out.println("정답입니다.\n");
                        count++;
                        totalCount++;
                    }else{
                        System.out.println("틀렸습니다. ( 답 : " + KeyValue + ")\n");
                        totalCount++;
                    }
                }
                System.out.println(" 결과 : " + count + " / " + totalCount + " \n");
                break;
            }else if(a == 2){
                break;
            }else{
                System.out.println(" 1 또는 2를 입력해주세요.");
            }
        }
    }

    // 5. 단어 목록보기
    @Override
    public void WordList(){
        System.out.println("-------- 목록 --------- ");

        Set Key = Word.keySet();
        Iterator iterator;

        for(iterator = Key.iterator(); iterator.hasNext();){
            String KeyValue = (String) iterator.next();
            String ValueVar = (String) Word.get(KeyValue);

            System.out.println("※ " + KeyValue + " : " + ValueVar);
        }
        System.out.println(" ----------------------- ");

        while (true) {
            System.out.println("목록으로 돌아가려면 Menu 입력 ");
            Scanner sc = new Scanner(System.in);
            String Menu = sc.nextLine();
            if (Menu.equals("Menu")) {
                break;
            }else{
                System.out.println("오류");
            }
        }
    }

    // 6. 종료
    @Override
    public void Exit(){
        System.out.println("영단어장을 종료합니다.");
    }

}