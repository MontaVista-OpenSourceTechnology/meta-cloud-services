Gem::Specification.new do |s|
  s.name        = 'puppet-vswitch'
  s.version     = '3.0.0'
  s.date        = '2015-11-27'
  s.summary     = "Puppet provider for virtual switches."
  s.description = s.summary
  s.authors     = ["Puppet Labs"]
  s.email       = ''
  s.files       = %w(LICENSE README.md Rakefile) + Dir.glob('{lib,spec}/**/*')
  s.homepage    = 'https://github.com/openstack/puppet-vswitch'
  s.license     = 'Apache 2.0'
end

