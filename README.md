# @TransactionalEventListener 예제
위 기능은 @EventListener 기능의 확장으로, 2개의 task에 대해서 기능 수행 결과를 연동할 수 있도록 하고 있다. 
* 본 예제에서는 new Customer 가 등록되면, 후속작업으로 해당 고객에 token 을 발행하고, 이를 db에 저장하는 기능을 예제로 사용하고 있다. 


## @Transactional 기능과 함께 사용되어야 한다. 
* task1 : @Service 콤포넌트에서 newCustomer 생성. and fire event.
* task2 : @EventListener 에서 generate token and save DB.
> 첫번째  taksk 에서 @Transactional 마킹을 해 주어야 한다. 이렇게 해 주어야 Event Listener 에서 @TransactionalEventListener 기능과 연동될 수 있다. 

### 참고 자료
[여기](https://dzone.com/articles/transaction-synchronization-and-spring-application)


