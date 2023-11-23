package umc5th.spring.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc5th.spring.domain.common.BaseEntity;
import umc5th.spring.domain.enums.Gender;
import umc5th.spring.domain.enums.MemberStatus;
import umc5th.spring.domain.enums.SocialType;
import umc5th.spring.domain.mapping.MemberFoodType;
import umc5th.spring.domain.mapping.MemberMission;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;
    //@Column(nullable = false, length = 50)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    //private Boolean status;
    @ColumnDefault("0")
    private Integer point;
    @Column(nullable = false, length = 40)
    private String address;
    @Column(nullable = true, length = 20)
    private String nickname;
    @Column(nullable = true, length = 12)
    private String phoneNumber;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFoodType> memberFoodTypeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
