//package com.example.springmaven.model;
//
//
//
//public class MyUserPredicate {
//
//    private SearchCriteria criteria;
//
//    public BooleanExpression getPredicate() {
//        PathBuilder<MyUser> entityPath = new PathBuilder<>(MyUser.class, "user");
//
//        if (isNumeric(criteria.getValue().toString())) {
//            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
//            int value = Integer.parseInt(criteria.getValue().toString());
//            switch (criteria.getOperation()) {
//                case ":":
//                    return path.eq(value);
//                case ">":
//                    return path.goe(value);
//                case "<":
//                    return path.loe(value);
//            }
//        }
//        else {
//            StringPath path = entityPath.getString(criteria.getKey());
//            if (criteria.getOperation().equalsIgnoreCase(":")) {
//                return path.containsIgnoreCase(criteria.getValue().toString());
//            }
//        }
//        return null;
//    }
//
//}
