from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait as wait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select

import time


browser = webdriver.Chrome()
browser.maximize_window()

browser.get('https://google.com')

element = wait(browser, 10).until(
EC.presence_of_element_located((By.NAME, 'q')))

search_form = browser.find_element_by_name('q')
search_form.send_keys('Dlaczego warto pracować w Nokii')
search_form.submit()
time.sleep(3)

browser.get('https://nokiawroclaw.pl')

element = wait(browser, 10).until(
EC.element_to_be_clickable((By.LINK_TEXT, 'Dołącz do nas')))

browser.find_element_by_link_text('Dołącz do nas').click()

element = wait(browser, 10).until(
EC.presence_of_element_located((By.XPATH, '//span[text()="Zobacz wszystkie oferty"]')))

button_zobacz_oferty = browser.find_element_by_xpath('//span[text()="Zobacz wszystkie oferty"]')
browser.execute_script('arguments[0].scrollIntoView({behavior: "smooth", block: "center"});', button_zobacz_oferty)

element = wait(browser, 10).until(
EC.visibility_of_element_located((By.XPATH, '//span[text()="Zobacz wszystkie oferty"]')))
time.sleep(2)

browser.find_element_by_xpath('//span[text()="Zobacz wszystkie oferty"]').click()

element = wait(browser, 10).until(
EC.title_contains('Oferty pracy'))

Select(browser.find_element_by_name('type')).select_by_value("10")
Select(browser.find_element_by_name('section')).select_by_value("37")
browser.find_element_by_xpath('//button[@class="btn btn--red btn--icon"]').click()
time.sleep(2)
browser.find_element_by_link_text('Test Automation Engineer').click()

element = wait(browser, 10).until(
EC.title_contains('Test Automation Engineer'))

browser.find_element_by_xpath('//a[@class="btn btn--red"]').click()

element = wait(browser, 10).until(
EC.title_contains('Test Automation Engineer'))

browser.find_element_by_xpath('//span[text()="Apply for Job"]').click()

element = wait(browser, 10).until(
EC.visibility_of_element_located((By.NAME, 'User.email')))

browser.find_element_by_name('User.email').send_keys('example@gmail.com')
time.sleep(5)

browser.find_element_by_xpath('//div[@class="submit_cancel jCloseModal"]').click()
time.sleep(3)

browser.quit()
quit()
