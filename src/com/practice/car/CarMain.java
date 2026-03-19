package com.practice.car;

// --- 1. 부모 클래스 (설계도) ---
class Car {
    // [빈칸 1] : 외부에서 함부로 주행거리를 못 건드리게 숨김! (캡슐화)
    private String modelName;
    private int mileage;

    public Car(String modelName, int mileage) {
        this.modelName = modelName;
        this.mileage = mileage;
    }

    // [빈칸 2] : 외부에서 정상적으로 주행거리를 늘릴 수 있게 열어둠! (캡슐화)
    public void drive(int distance) {
        this.mileage += distance;
        System.out.println(modelName + " 주행 완료. 누적: " + mileage + "km");
    }

    public void checkMaintenance() {
        System.out.println(modelName + " 일반 점검: 1만km 기준 엔진오일 교체");
    }

    // 숨겨진 modelName을 자식 클래스에서 쓸 수 있게 해주는 기능
    public String getModelName() { 
        return modelName; 
    }
}

// --- 2. 자식 클래스 (상속) ---
// [빈칸 3] : Car 클래스의 기본 기능을 그대로 물려받음!
class SportsCar extends Car {
    
    public SportsCar(String modelName, int mileage) {
        // [빈칸 4] : 부모 클래스의 기본 세팅(생성자)을 그대로 부름!
        super (modelName, mileage);
    }

    // [빈칸 5] : 부모의 checkMaintenance()를 고성능차 버전에 맞게 덮어씀! (다형성)
    @Override
    public void checkMaintenance() {
        System.out.println("🔥 " + getModelName() + " 고성능 점검: 5천km 기준 하이그립 타이어 및 고급 합성유 확인 필수!");
    }
}

// --- 3. 메인 실행 클래스 ---
public class CarMain {
    public static void main(String[] args) {
        
        // [빈칸 6] : 도면(클래스)을 바탕으로 진짜 실체(인스턴스)를 메모리에 띄움!
        Car myAvante = new Car("아반떼 AD 디젤", 50000);
        SportsCar myM2 = new SportsCar("F87 M2", 30000);
        SportsCar myCls = new SportsCar("CLS 53 AMG", 15000);

        System.out.println("--- 주행 시작 ---");
        myAvante.drive(50);
        myM2.drive(120);
        myCls.drive(80);

        System.out.println("\n--- 정비소 입고 (다형성 확인) ---");
        
        // 똑같은 checkMaintenance() 명령을 내렸지만 차종에 따라 다르게 작동함!
        
        myAvante.checkMaintenance();
        myM2.checkMaintenance();
        myCls.checkMaintenance();
    }
}