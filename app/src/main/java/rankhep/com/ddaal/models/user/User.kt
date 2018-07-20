package rankhep.com.ddaal.models.user

import java.io.Serializable

class User(var id:String,
           var password:String,
           var token:String,
           var user_data: UserData,
           var user_location: UserLocation,
           var user_contract: UserContract,
           var user_setting: UserSetting):Serializable
//User
//id
//
//type : String
//유저 아이디를 의미합니다
//password
//
//type : String
//유저 비밀번호를 의미합니다
//token
//
//type : String
//유저 토큰을 의미합니다
//user_data
//
//type : Object
//유저 정보를 가지고있는 오브젝트입니다
//name
//
//type : String
//유저 이름울 의미합니다
//age
//
//type : Number
//유저 나이를 의미합니다
//admin
//
//type : Boolean
//알바생인지 고용주인지 판단합니다
//true : 고용주
//false : 알바생
//profile_image_url
//
//type : String
//유저 프로필 사진 url을 의미합니다
//user_location
//
//type : Object
//유저 위치를 가지고있는 오브젝트입니다
//user_latitude
//
//type : String
//유저 위도를 의미합니다
//user_longitude
//
//type : String
//유저 경도를 의미합니다
//user_hash_tag
//
//type : Object
//유저 해시테그 리스트를 의미합니다
//EX user_hash_tag:{ [ hash_tag:편의점 ], [ hash_tag:야간 ] }
//
//user_contract
//
//type : Object
//유저 근로 계약서 정보를 담고있는 오브젝트입니다
//user_contract_image_url
//
//type : String
//유저 근로 계약서 이미지 url
//user_contract_pdf_url
//
//type : String
//유저 근로 계약서 pdf url
//user_setting
//
//type : Object
//유저 세팅 정보를 담고있는 오브젝트입니다
//notification_allow
//
//type : Boolean
//땜빵 알림 기능을 사용여부
