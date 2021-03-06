// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/base.css'
import './assets/css/index.css'
import axios from 'axios'
import Cookies from 'js-cookie';
axios.defaults.withCredentials=true
axios.defaults.baseURL = "http://localhost:8088/";
Vue.prototype.$ajax = axios
Vue.config.productionTip = false
Vue.use(ElementUI);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
