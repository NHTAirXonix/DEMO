//package com.example.springmaven.repository;
//
//
//import com.example.springmaven.model.MyUser;
//
//public interface MyUserRepository extends JpaRepository<MyUser, Long>,
//        QuerydslPredicateExecutor<MyUser>, QuerydslBinderCustomizer<QMyUser> {
//    @Override
//    default public void customize(
//            QuerydslBindings bindings, QMyUser root) {
//        bindings.bind(String.class)
//                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//        bindings.excluding(root.email);
//    }
//}
