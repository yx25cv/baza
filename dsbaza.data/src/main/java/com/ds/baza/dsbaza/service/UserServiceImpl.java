package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.commands.UserCommand;
import com.ds.baza.dsbaza.model.user.Role;
import com.ds.baza.dsbaza.model.user.User;
import com.ds.baza.dsbaza.model.user.UserRole;
import com.ds.baza.dsbaza.repository.RoleRepository;
import com.ds.baza.dsbaza.repository.UserRepository;
import com.ds.baza.dsbaza.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class UserServiceImpl implements UserService {

    private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private PasswordEncoder passwordEncoder;

        //@Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @EventListener
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void afterApplicationReady(ApplicationReadyEvent event1) {
        //ovaj listener će isto tako biti pokrenut pri pokretanju aplicakje ali mora biti definisan u interfejsu koji implementira klasa
//ovde proveravam vrednost rola za user-a, ovaj test nam vise ne treba
//        User user2 = userRepository.findByUsername("user").orElse(null);
//        for (UserRole userRole : user2.getUserRoles()){
//            System.out.println(userRole.getRole().getName());
//        }

        User user = new User();

        if (!userRepository.findByUsername("admin").isPresent()) {
            user.setUsername("admin");
            //user.setName(adminName);
            user.setPassword(passwordEncoder.encode("admin"));
            Role role1 = new Role();
            role1.setRoleId(2);
            role1.setName("ROLE_ADMIN");
            user.getUserRoles().add(new UserRole(user, role1));


            userRepository.save(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void signup (UserCommand userCommand, Role role) {
        User user = userCommand.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role2 = roleRepository.findByName(role.getName());
        LOG.warn("Vrednost role je: {}", role.getName());
        user.getUserRoles().add(new UserRole(user, role2));
        LOG.warn("Vrednost rola je {}", user.getUserRoles().getClass().getName());
        userRepository.save(user);
        //ovde sada mozes napisati kod kojim nakon signup-a odmah ulogujes usera, jer smo te kodove napisali u MyUtils klasi.
        //medjutim ako uradimo ovo MyUtils.login(user); nastaje problem jer je ovo transakcioni metod tako da ce se komitovanje desiti
        //tek na izlasku iz koda pa se moe desiti da tu nesto pukne pri upisu u bazu a vec imamo ulogovanog korsnika
        //zato to radimo na sledeći način
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//            @Override
//            public void afterCommit() {
//                MyUtils.login(user);
//            }
//        });
        //medjutim taj ceo ovaj zakomentarisani metod nije lose prebaciti u MyUtils klasu i da ga ovde samo pozoves:
//        MyUtils.afterCommit(() -> MyUtils.login(user));
    }
}
